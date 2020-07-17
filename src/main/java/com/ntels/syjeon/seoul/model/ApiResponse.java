package com.ntels.syjeon.seoul.model;

import com.ntels.syjeon.seoul.model.seoul.Octastatapi419;
/**
 * 서울시 공공데이터 Api Response 모델
 * @author syjeon@ntels.com
 */
public class ApiResponse {
    /**
     * 결과 하위 노드 모델
     */
    private Octastatapi419 octastatapi419;
    
    public Octastatapi419 getOctastatapi419()
    {
        return octastatapi419;
    }
    public void setOctastatapi419(Octastatapi419 octastatapi419)
    {
        this.octastatapi419 = octastatapi419;
    }
    @Override
    public String toString() {
        return "SeoulResult{" +
                "response=" + octastatapi419 +
                '}';
    }
}
