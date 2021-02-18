package com.ct.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSONObject;
import com.ct.Utils.ImportDataListener;
import com.ct.entity.*;
import com.ct.service.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("terminal")
public class TerminalController {

    @Resource
    private terminalsService terminalsService;

    @Resource
    private OrganizationService organizationService;

    @Resource
    private CategoryService categoryService;

    @Resource
    private MainCategoryService mainCategoryService;

    @Resource
    private AreaService areaService;

    @GetMapping("selectList")
    public String selectList(Model model, @RequestParam(value = "pn", defaultValue = "1") int pn, @RequestParam(value = "size", defaultValue = "10") int size){
        PageHelper.startPage(pn, size, "ter_id");
        List<terminals> terminalsList = terminalsService.queryList();
        PageInfo<terminals> page = new PageInfo<>(terminalsList);
        model.addAttribute("page",page);
        return "terminals/terminal-list";
    }

//    @GetMapping("export")
//    public String export(){
//        return "terminals/terminal-export";
//    }
//
//    @ResponseBody
//    @RequestMapping("json")
//    public Object json(){
//        List<terminals> terminalsList = terminalsService.queryList();
//        Map<String,Object> map = new LinkedHashMap<>();
//        map.put("status",200);
//        map.put("message","");
//        map.put("total",terminalsList.size());
//        map.put("item",terminalsList);
//        return map;
//    }

    /**
     * 点击[添加]，跳转到terminal-add页面
     *
     * @return return前不可以加/
     */
    @GetMapping("to-terminal-add")
    public String toTerminalAdd(Model model){
        List<organization> organizations = organizationService.queryAllOrg();
        List<category> categories = categoryService.queryAllCategory();
        List<mainCategory> mainCategories = mainCategoryService.queryAllMainCategory();
        List<area> areas = areaService.queryAllArea();
        model.addAttribute("organizations",organizations);
        model.addAttribute("categories",categories);
        model.addAttribute("mainCategories",mainCategories);
        model.addAttribute("areas", areas);
        return "terminals/terminal-add";
    }

    /**
     *
     * @param terminals
     * @return
     */
    @PostMapping("add")
    public String add(terminals terminals) {
        terminalsService.insert(terminals);
        return "redirect:/terminal/selectList";

    }

    @GetMapping("to-terminal-edit/{id}")
    public String toEdit(@PathVariable("id") String id, Model model){
//        System.out.println(id);
        terminals terminal = terminalsService.queryById(id);
        List<organization> organizations = organizationService.queryAllOrg();
        List<area> areas = areaService.queryAllArea();
        List<mainCategory> mainCategories = mainCategoryService.queryAllMainCategory();
        List<category> categories = categoryService.queryAllCategory();
        model.addAttribute("terminal", terminal);
        model.addAttribute("organizations", organizations);
        model.addAttribute("areas", areas);
        model.addAttribute("mainCategories", mainCategories);
        model.addAttribute("categories", categories);
        return"terminals/terminal-edit";
    }

    @PostMapping("update")
    public String update(terminals terminals){
            terminalsService.update(terminals);
            return "redirect:/terminal/selectList";
    }

    @GetMapping("to-look-more/{id}")
    public String toLookMore(@PathVariable("id") String id, Model model){
        System.out.println(id);
        terminals terminal = terminalsService.queryById(id);
//        System.out.println(terminal.getBrand());
        model.addAttribute("terminal",terminal);
        return "terminals/terminal-more";
    }

    @GetMapping("deleteById")
    public String deleteById(Integer id){
        terminalsService.deleteById(id);
        return "redirect:/terminal/selectList";
    }

    @GetMapping("exportExcel")
    public String exportExcel(){
        //设置导出目录为桌面
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        File desktopDir = FileSystemView.getFileSystemView() .getHomeDirectory();
        String desktopPath = desktopDir.getAbsolutePath();
        String fileName = desktopPath + File.separator + "终端" + sdf.format(new Date()) + ".xlsx";
        //将terminals对象重新封装成ExportExcel
        List<ExportExcel> exportExcels = new ArrayList<>();
        List<terminals> terminalsList = terminalsService.queryList();
        for (terminals t : terminalsList){
            ExportExcel exportExcel = new ExportExcel(t);
            exportExcels.add(exportExcel);
        }
        //排除多余的表头字段
        Set<String> excludeClumnFiledNames = new HashSet<>();
        excludeClumnFiledNames.add("terminals");
        //导出
        EasyExcel.write(fileName, ExportExcel.class).excludeColumnFiledNames(excludeClumnFiledNames).sheet("终端").doWrite(exportExcels);
        return "redirect:/terminal/selectList";
    }

    @ResponseBody
    @RequestMapping("countTerminalByArea")
    public JSONObject countTerminalByArea(){
        System.out.println("countTerminalByArea请求");
        JSONObject jsonObject = new JSONObject();
        List<JSONObject> jsonObjectList = new ArrayList<>();
        List<area> areas = areaService.queryAllArea();
        for (area a : areas){
            int sum = terminalsService.countByAreaId(a.getArea_id());
            JSONObject jsonObject1 = new JSONObject();
            jsonObject1.put("value", sum);
            jsonObject1.put("name", a.getArea_name());
            jsonObjectList.add(jsonObject1);
        }
        jsonObject.put("data_pie", jsonObjectList);
        System.out.println(jsonObject);
        return jsonObject;
    }



}
