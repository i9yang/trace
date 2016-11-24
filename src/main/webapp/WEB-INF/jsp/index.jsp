<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8"/static/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>

    <title>DataTables | Gentallela</title>

    <!-- Bootstrap -->
    <link href="/static/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet"/>
    <!-- Font Awesome -->
    <link href="/static/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet"/>
    <!-- iCheck -->
    <link href="/static/vendors/iCheck/skins/flat/green.css" rel="stylesheet"/>
    <!-- Datatables -->
    <link href="/static/vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet"/>
    <link href="/static/vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css" rel="stylesheet"/>
    <link href="/static/vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css" rel="stylesheet"/>
    <link href="/static/vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css" rel="stylesheet"/>
    <link href="/static/vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css" rel="stylesheet"/>

    <!-- Custom Theme Style -->
    <link href="/static/css/custom.min.css" rel="stylesheet"/>
</head>

<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <div class="col-md-3 left_col">
            <div class="left_col scroll-view">
                <div class="clearfix"></div>
                <br/>
                <!-- sidebar menu -->
                <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
                    <div class="menu_section">
                        <h3>General</h3>
                        <ul class="nav side-menu">
                            <li><a><i class="fa fa-home"></i> Home <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="index.html">Dashboard</a></li>
                                    <li><a href="index2.html">Dashboard2</a></li>
                                    <li><a href="index3.html">Dashboard3</a></li>
                                </ul>
                            </li>
                            <li><a><i class="fa fa-edit"></i> Forms <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="form.html">General Form</a></li>
                                    <li><a href="form_advanced.html">Advanced Components</a></li>
                                    <li><a href="form_validation.html">Form Validation</a></li>
                                    <li><a href="form_wizards.html">Form Wizard</a></li>
                                    <li><a href="form_upload.html">Form Upload</a></li>
                                    <li><a href="form_buttons.html">Form Buttons</a></li>
                                </ul>
                            </li>
                            <li><a><i class="fa fa-desktop"></i> UI Elements <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="general_elements.html">General Elements</a></li>
                                    <li><a href="media_gallery.html">Media Gallery</a></li>
                                    <li><a href="typography.html">Typography</a></li>
                                    <li><a href="icons.html">Icons</a></li>
                                    <li><a href="glyphicons.html">Glyphicons</a></li>
                                    <li><a href="widgets.html">Widgets</a></li>
                                    <li><a href="invoice.html">Invoice</a></li>
                                    <li><a href="inbox.html">Inbox</a></li>
                                    <li><a href="calendar.html">Calendar</a></li>
                                </ul>
                            </li>
                            <li><a><i class="fa fa-table"></i> Tables <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="tables.html">Tables</a></li>
                                    <li><a href="tables_dynamic.html">Table Dynamic</a></li>
                                </ul>
                            </li>
                            <li><a><i class="fa fa-bar-chart-o"></i> Data Presentation <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="chartjs.html">Chart JS</a></li>
                                    <li><a href="chartjs2.html">Chart JS2</a></li>
                                    <li><a href="morisjs.html">Moris JS</a></li>
                                    <li><a href="echarts.html">ECharts</a></li>
                                    <li><a href="other_charts.html">Other Charts</a></li>
                                </ul>
                            </li>
                            <li><a><i class="fa fa-clone"></i>Layouts <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="fixed_sidebar.html">Fixed Sidebar</a></li>
                                    <li><a href="fixed_footer.html">Fixed Footer</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>

        <div class="right_col" role="main">
            <div class="">
                <div class="page-title">
                    <div class="title_left">
                        <h3>검색 커버리지</h3>
                    </div>
                </div>

                <div class="clearfix"></div>
                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>Coverage</h2>
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">
                                <table id="datatable" class="table table-striped table-bordered">
                                    <thead>
                                    <tr>
                                        <th>집계기준일</th>
                                        <th>사이트 번호</th>
                                        <th>사이트 명</th>
                                        <th>디바이스 명</th>
                                        <th>전체쿼리 수</th>
                                        <th>성공쿼리 수</th>
                                        <th>검색 성공율</th>
                                        <th>실패쿼리 수</th>
                                        <th>실패쿼리2 수</th>
                                        <th>검색 실패율</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="i" items="${list}">
                                        <tr>
                                            <td>${i.CRITN_DT}</td>
                                            <td>${i.SITE_NO}</td>
                                            <td>${i.SSG_SITE.SITE_NM}</td>
                                            <td></td>
                                            <td>${i.PV_COUNT}</td>
                                            <td>${i.SUCCESS_COUNT}</td>
                                            <td><fmt:formatNumber value="${i.SUCCESS_COUNT / i.PV_COUNT * 100}" pattern=".000"/></td>
                                            <td>${i.NR1_COUNT}</td>
                                            <td>${i.NR2_COUNT}</td>
                                            <td><fmt:formatNumber value="${i.NR2_COUNT / i.PV_COUNT  * 100}" pattern=".000"/></td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                    <tfoot>
                                    <tr>
                                        <th>집계기준일</th>
                                        <th>사이트 번호</th>
                                        <th>사이트 명</th>
                                        <th>디바이스 명</th>
                                        <th>전체쿼리 수</th>
                                        <th>성공쿼리 수</th>
                                        <th>검색 성공율</th>
                                        <th>실패쿼리 수</th>
                                        <th>실패쿼리2 수</th>
                                        <th>검색 실패율</th>
                                    </tr>
                                    </tfoot>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="/static/vendors/jquery/dist/jquery.min.js"></script>
<script src="/static/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- FastClick -->
<script src="/static/vendors/fastclick/lib/fastclick.js"></script>
<script src="/static/vendors/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="/static/vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
<script src="/static/vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
<script src="/static/vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
<script src="/static/vendors/datatables.net-buttons/js/buttons.flash.min.js"></script>
<script src="/static/vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
<script src="/static/vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
<script src="/static/vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
<script src="/static/vendors/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
<script src="/static/vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
<script src="/static/vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
<script src="/static/vendors/datatables.net-scroller/js/datatables.scroller.min.js"></script>
<script src="/static/vendors/jszip/dist/jszip.min.js"></script>
<script src="/static/vendors/pdfmake/build/pdfmake.min.js"></script>
<script src="/static/vendors/pdfmake/build/vfs_fonts.js"></script>

<!-- Custom Theme Scripts -->
<script src="/static/js/custom.min.js"></script>

<!-- Datatables -->
<script>
    //	$.extend( true, $.fn.dataTable.defaults, {
    //		"searching": false,
    //		"ordering": false,
    //		"aLengthMenu" : [100, 200, 300, 400],
    //		"iDisplayLength" : 100
    //	} );
    //	$(document).ready(function() {
    //		$('#datatable').dataTable({
    //			"ajax" : "/coverage"
    //		});
    //	});
</script>
<!-- /Datatables -->
</body>
</html>