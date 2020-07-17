package com.ntels.syjeon.seoul.model.seoul;

import java.util.List;
/**
 * 서울시 Api Response 하위 모델
 * @author syjeon@ntels.com
 */
public class Octastatapi419 {
    /**
     * 조회 결과 수
     */
    private String list_total_count;

    /**
     * 자치구 모델 리스트
     */
    private List<Row> row;

    /**
     * 결과 메시지
     */
    private Result result;

    public String getList_Total_Count() {
        return list_total_count;
    }

    public void setList_Total_Count(String list_Total_Count) {
        this.list_total_count = list_Total_Count;
    }

    public List<Row> getRow() {
        return row;
    }

    public void setRow(List<Row> row) {
        this.row = row;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Octastatapi419{" +
                "list_Total_Count='" + list_total_count + '\'' +
                ", row=" + row +
                ", result=" + result +
                '}';
    }
}
