package com.ntels.syjeon.seoul.model.seoul;

import java.util.List;

public class Octastatapi419 {
    private String list_total_count;

    private List<Row> row;

    private RESULT RESULT;

    public String getList_total_count ()
    {
        return list_total_count;
    }

    public void setList_total_count (String list_total_count)
    {
        this.list_total_count = list_total_count;
    }

    public List<Row> getRow() {
        return row;
    }

    public void setRow(List<Row> row) {
        this.row = row;
    }

    public RESULT getRESULT ()
    {
        return RESULT;
    }

    public void setRESULT (RESULT RESULT)
    {
        this.RESULT = RESULT;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [list_total_count = "+list_total_count+", row = "+row+", RESULT = "+RESULT+"]";
    }
}
