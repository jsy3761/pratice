<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>서울시 자치구 별 인구 현황</title>
  <script src="../../scripts/atom/jquery.1.11.2.min.js"></script>
  <!-- datetime, date, time -->
  <script src="../../scripts/atom/datetimepicker.moment.js"></script>
  <script src="../../scripts/atom/datetimepicker.js"></script>
  <!-- multiselect -->
  <script src="../../scripts/atom/bootstrap-multiselect.js"></script>
  <!-- 공통작성 -->
  <script src="../../scripts/atom/ui_common.js"></script>
  <link rel="shortcut icon" type="image/x-icon" href="../../images/atom/favicon.ico">
  <link rel="stylesheet" href="../../styles/atom/style.css">
  <link rel="stylesheet" href="../../styles/thingplug/thingplug.css">
  <script>
      function event(){
          var child = document.getElementById('${item.JACHIGU}');


      }
  </script>
</head>

<body>
  <div class="header"></div>
  <div class="wrap">
    <div class="content">
      <h2 class="h2">서울 특별시 자치구 별 인구 현황 리스트</h2>
      <div class="cont_wrap">
        <ul class="tab_menu type_02">
          <li class="active"><!-- Selected tab -->
            <a href="view"><span class="txt">서울특별시</span></a>
          </li>
        </ul>
        <div class="search_area auto hidden">
          <div class="search_box">
            <table>
              <tbody>
                <tr>
                  <th>Package</th>
                  <td>
                    <div class="select type_01 m">
                      <select id="select_temp_id_0">
                        <option value="1">select m</option>
                        <option value="2">option_01</option>
                        <option value="3">option_02</option>
                      </select>
                    </div>
                  </td>
                </tr>
                <tr>
                  <th>Node</th>
                  <td>
                    <div class="select type_01 m">
                      <select id="select_temp_id_1">
                        <option value="1">select m</option>
                        <option value="2">option_01</option>
                        <option value="3">option_02</option>
                      </select>
                    </div>
                  </td>
                </tr>
              </tbody>
            </table>
          </div>
          <div class="btn_box">
            <button type="button" class="btn search">
              Search
            </button>
          </div>
        </div>
        <div class="layout type_01">
          <div class="cell type_01">
            <div class="box">
              <div class="loading hide"><span></span></div>
              <div class="search_message hide">검색하신 내용이 없습니다.<br>Package와 Node를 선택해 주십시오.</div>
              <ul class="side_menu">
                <c:forEach var="item" items="${rowList}">
                  <li><a href="/view?guname=${item}" id="${item}" onclick="event()">${item}</a></li>
                </c:forEach>   
              </ul>
            </div>
          </div>
          <div class="cell">
            <div class="box">
              <div class="loading hide"><span></span></div>
              <div class="search_message hide">선택된 내용이 없습니다.<br>왼쪽에서 Resource를 선택해 주십시오.</div>
              <div class="table type_03 detail">
                <table>
                  <tbody>
                    <tr>
                      <th>
                        <span><h2>${row.JACHIGU}</h2></span>
                      </th>
                      <td>
                        <!-- Atom Resource -->
                        <table class="td_value">
                          <tr>
                            <td class="s">
                              <span class="label">Use Resource Group</span>
                              <div class="switch type_01">
                                <input type="checkbox" id="temp_id_11" checked disabled>
                                <label for="temp_id_11"></label>
                              </div>
                            </td>
                            <td class="s">
                              <span class="label"><h2>조회 기간</h2></span>
                              <div class="value"><h2>${row.GIGAN} 분기</h2></div>
                            </td>
                            <form action="view" id="gigan">
                              <td>
                                <span class="label"><h2>기간 입력 2010.1-4 ~ 2020.1-4</h2></span>
                              <input type="text" size="30" name="gigan" placeholder="예)2020년 1/4분기 -> 2020.1-4 "> 
                              <input type="hidden" name="guname" value="${row.JACHIGU}"><br />
                              <button class="btn type_02 primary" type="submit" form="gigan">조회</button>
                              </td>
                            </form>
                          </tr>
                          <tr>
                            <td class="s">
                              <span class="label">Collect Statistics</span>
                              <div class="switch type_01">
                                <input type="checkbox" id="temp_id_12" disabled>
                                <label for="temp_id_12"></label>
                              </div>
                            </td>
                            <td class="s">
                              <span class="label"><h2>세대 수</h2></span>
                              <div class="value"><h2>${row.SEDAE}</h2></div>
                              <span class="unit"></span>
                            </td>
                          </tr>
                        </table>
                        <!-- Node Resource -->
                        <table class="td_value hide">
                          <tr>
                            <td class="s">
                              <span class="label">Use Flag</span>
                              <div class="switch type_01">
                                <input type="checkbox" id="temp_id_13" checked disabled>
                                <label for="temp_id_13"></label>
                              </div>
                            </td>
                            <td class="s">
                              <span class="label">File Creation Cycle</span>
                              <div class="value">100</div>
                              <span class="unit">secs</span>
                            </td>
                          </tr>
                          <tr>
                            <td class="s">
                              <span class="label">Collect Statistics</span>
                              <div class="switch type_01">
                                <input type="checkbox" id="temp_id_14" disabled>
                                <label for="temp_id_14"></label>
                              </div>
                            </td>
                            <td class="s">
                              <span class="label">Statistics Period</span>
                              <div class="value">20</div>
                              <span class="unit">mins</span>
                            </td>
                            <td>
                              <span class="label">Metric Name</span>
                              <div class="value">connection.status</div>
                            </td>
                          </tr>
                        </table>
                      </td>
                    </tr>
                    <tr>
                      <th>
                        <span><h2>인구수</h2></span>
                      </th>
                      <td>
                          <div class="thead">
                            <table>
                              <thead>
                                <tr>
                                  <th scope="col" class="tac"><h2>남 여 총합</h2></th>
                                  <th scope="col" class="tac"><h2>남자</h2></th>
                                  <th scope="col" class="tac"><h2>여자</h2></th>
                                </tr>
                              </thead>
                            </table>
                          </div>
                          <div class="tbody">
                            <table>
                              <tbody>
                                <tr>
                                  <td class="tac"><h2>${row.GYE_1} 명</h2></td>
                                  <td class="tac"><h2>${row.NAMJA_1} 명</h2></td>
                                  <td class="tac"><h2>${row.YEOJA_1} 명</h2></td>
                                </tr>
                              </tbody>
                            </table>
                          </div>
                        <br /> <br />
            
                        <div class="thead">
                          <table>
                            <thead>
                              <tr>
                                <th scope="col" class="tac"><h2>세대당 인구</h2></th>
                                <th scope="col" class="tac"><h2>65세 이상 고령자</h2></th>
                              </tr>
                            </thead>
                          </table>
                        </div>
                        <div class="tbody">
                          <table>
                            <tbody>
                              <tr>
                                <td class="tac"><h2>${row.SEDAEDANGINGU} 명</h2></td>
                                <td class="tac"><h2>${row.n_65SEISANGGORYEONGJA} 명</h2></td>
                              </tr>
                            </tbody>
                          </table>
                        </div>
                      </td>
                    </tr>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>

</html>