package com.easydatabaseexport.ui.export;

import com.easydatabaseexport.common.CommonConstant;
import com.easydatabaseexport.entities.TableParameter;
import com.easydatabaseexport.enums.ConfigEnum;
import com.easydatabaseexport.enums.YesNoEnum;
import com.easydatabaseexport.ui.component.JCheckBoxTree;
import com.easydatabaseexport.ui.export.config.ExportFileType;
import com.easydatabaseexport.util.ExportExcelUtil;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;

/**
 * ExcelActionListener
 *
 * @author lzy
 * @date 2022/11/10 9:33
 **/
@Log4j
public class ExcelActionListener extends AbstractActionListener implements ActionListener {


    public ExcelActionListener(final JCheckBoxTree.CheckNode root) {
        super.root = root;
        super.suffix = ExportFileType.EXCEL.getSuffix();
    }

    @SneakyThrows
    @Override
    public boolean export(File file) {
        FileOutputStream outputStream = new FileOutputStream(file.getAbsolutePath());
        ExportExcelUtil<TableParameter> util = new ExportExcelUtil<TableParameter>();
        boolean isMoreSheet = YesNoEnum.YES_1.getValue().equals(CommonConstant.configMap.get(ConfigEnum.SHEET.getKey()));
        util.exportExcel("表结构导出", CommonConstant.COLUMN_HEAD_NAMES, listMap, outputStream, isMoreSheet);
        return Boolean.TRUE;
    }


}
