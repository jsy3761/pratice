package com.ntels.syjeon.seoul.model.seoul;

/**
 * 서울시 Api Response 결과 메시지 모델
 * @author syjeon@ntels.com
 */
public class Result {
    /**
     * 결과 코드
     */
    private String CODE;

    /**
     * 결과 메시지
     */
    private String MESSAGE;

    public void setCODE(String CODE){
        this.CODE = CODE;
    }
    public String getCODE(){
        return this.CODE;
    }
    public void setMESSAGE(String MESSAGE){
        this.MESSAGE = MESSAGE;
    }
    public String getMESSAGE(){
        return this.MESSAGE;
    }

    @Override
    public String toString() {
        return "Result{" +
                "CODE='" + CODE + '\'' +
                ", MESSAGE='" + MESSAGE + '\'' +
                '}';
    }
}
