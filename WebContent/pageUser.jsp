<%@page import="yama.database.Account"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>My Web Admin</title>

<!-- Bootstrap Core CSS -->
<link href="CSS/bootstrap.min.css" rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="CSS/metisMenu.min.css" rel="stylesheet">

<!-- DataTables CSS -->
<link href="CSS/dataTables.bootstrap.css" rel="stylesheet">

<!-- DataTables Responsive CSS -->
<link href="CSS/dataTables.responsive.css" rel="stylesheet">
<!-- Custom CSS -->
<link href="CSS/sb-admin-2.css" rel="stylesheet">

<!-- Morris Charts CSS -->
<link href="CSS/morris.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="CSS/font-awesome.min.css" rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body style="background-color: #999966;">
	<div class="row">
		<div class="col-lg-12 col-md-12">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<div class="row">
						<!--
                    
                        <div class="col-xs-2">
                            <i class="fa fa-steam fa-5x"></i>
                        </div>
                             -->
						<div class="col-xs-12 text-center">
							<div class="huge">WEB ADMIN APP MUSIC ANDROID</div>
							<div>YAMATEAM - KTPM4 - K9 - HAUI</div>
						</div>
						<!--
                        <div class="col-xs-2">
                            <i class="fa fa-steam fa-5x"></i>
                        </div>
                        -->
					</div>
				</div>
			</div>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.html"
				style="text-align: center; color: blue;">Trường Đại Học Công
				Nghiệp Hà Nội</a>
		</div>
		<!-- /.navbar-header -->

		<ul class="nav navbar-top-links navbar-right">
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#"> <i class="fa fa-envelope fa-fw"></i>
					<i class="fa fa-caret-down"></i>
			</a>
				<ul class="dropdown-menu dropdown-messages">
					<li><a href="#">
							<div>
								<strong>John Smith</strong> <span class="pull-right text-muted">
									<em>Yesterday</em>
								</span>
							</div>
							<div>Lorem ipsum dolor sit amet, consectetur adipiscing
								elit. Pellentesque eleifend...</div>
					</a></li>
					<li class="divider"></li>
					<li><a href="#">
							<div>
								<strong>John Smith</strong> <span class="pull-right text-muted">
									<em>Yesterday</em>
								</span>
							</div>
							<div>Lorem ipsum dolor sit amet, consectetur adipiscing
								elit. Pellentesque eleifend...</div>
					</a></li>
					<li class="divider"></li>
					<li><a href="#">
							<div>
								<strong>John Smith</strong> <span class="pull-right text-muted">
									<em>Yesterday</em>
								</span>
							</div>
							<div>Lorem ipsum dolor sit amet, consectetur adipiscing
								elit. Pellentesque eleifend...</div>
					</a></li>
					<li class="divider"></li>
					<li><a class="text-center" href="#"> <strong>Read
								All Messages</strong> <i class="fa fa-angle-right"></i>
					</a></li>
				</ul> <!-- /.dropdown-messages --></li>
			<!-- /.dropdown -->
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#"> <i class="fa fa-tasks fa-fw"></i>
					<i class="fa fa-caret-down"></i>
			</a>
				<ul class="dropdown-menu dropdown-tasks">
					<li><a href="#">
							<div>
								<p>
									<strong>Task 1</strong> <span class="pull-right text-muted">40%
										Complete</span>
								</p>
								<div class="progress progress-striped active">
									<div class="progress-bar progress-bar-success"
										role="progressbar" aria-valuenow="40" aria-valuemin="0"
										aria-valuemax="100" style="width: 40%">
										<span class="sr-only">40% Complete (success)</span>
									</div>
								</div>
							</div>
					</a></li>
					<li class="divider"></li>
					<li><a href="#">
							<div>
								<p>
									<strong>Task 2</strong> <span class="pull-right text-muted">20%
										Complete</span>
								</p>
								<div class="progress progress-striped active">
									<div class="progress-bar progress-bar-info" role="progressbar"
										aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"
										style="width: 20%">
										<span class="sr-only">20% Complete</span>
									</div>
								</div>
							</div>
					</a></li>
					<li class="divider"></li>
					<li><a href="#">
							<div>
								<p>
									<strong>Task 3</strong> <span class="pull-right text-muted">60%
										Complete</span>
								</p>
								<div class="progress progress-striped active">
									<div class="progress-bar progress-bar-warning"
										role="progressbar" aria-valuenow="60" aria-valuemin="0"
										aria-valuemax="100" style="width: 60%">
										<span class="sr-only">60% Complete (warning)</span>
									</div>
								</div>
							</div>
					</a></li>
					<li class="divider"></li>
					<li><a href="#">
							<div>
								<p>
									<strong>Task 4</strong> <span class="pull-right text-muted">80%
										Complete</span>
								</p>
								<div class="progress progress-striped active">
									<div class="progress-bar progress-bar-danger"
										role="progressbar" aria-valuenow="80" aria-valuemin="0"
										aria-valuemax="100" style="width: 80%">
										<span class="sr-only">80% Complete (danger)</span>
									</div>
								</div>
							</div>
					</a></li>
					<li class="divider"></li>
					<li><a class="text-center" href="#"> <strong>See
								All Tasks</strong> <i class="fa fa-angle-right"></i>
					</a></li>
				</ul> <!-- /.dropdown-tasks --></li>
			<!-- /.dropdown -->
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#"> <i class="fa fa-bell fa-fw"></i>
					<i class="fa fa-caret-down"></i>
			</a>
				<ul class="dropdown-menu dropdown-alerts">
					<li><a href="#">
							<div>
								<i class="fa fa-comment fa-fw"></i> New Comment <span
									class="pull-right text-muted small">4 minutes ago</span>
							</div>
					</a></li>
					<li class="divider"></li>
					<li><a href="#">
							<div>
								<i class="fa fa-twitter fa-fw"></i> 3 New Followers <span
									class="pull-right text-muted small">12 minutes ago</span>
							</div>
					</a></li>
					<li class="divider"></li>
					<li><a href="#">
							<div>
								<i class="fa fa-envelope fa-fw"></i> Message Sent <span
									class="pull-right text-muted small">4 minutes ago</span>
							</div>
					</a></li>
					<li class="divider"></li>
					<li><a href="#">
							<div>
								<i class="fa fa-tasks fa-fw"></i> New Task <span
									class="pull-right text-muted small">4 minutes ago</span>
							</div>
					</a></li>
					<li class="divider"></li>
					<li><a href="#">
							<div>
								<i class="fa fa-upload fa-fw"></i> Server Rebooted <span
									class="pull-right text-muted small">4 minutes ago</span>
							</div>
					</a></li>
					<li class="divider"></li>
					<li><a class="text-center" href="#"> <strong>See
								All Alerts</strong> <i class="fa fa-angle-right"></i>
					</a></li>
				</ul> <!-- /.dropdown-alerts --></li>
			<!-- /.dropdown -->
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i>
					<i class="fa fa-caret-down"></i>
			</a>
				<ul class="dropdown-menu dropdown-user">
					<li><a href="#"><i class="fa fa-user fa-fw"></i> User
							Profile</a></li>
					<li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
					</li>
					<li class="divider"></li>
					<li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i>
							Logout</a></li>
				</ul> <!-- /.dropdown-user --></li>
			<!-- /.dropdown -->
		</ul>
		<!-- /.navbar-top-links -->

		<div class="navbar-default sidebar" role="navigation">
			<div class="sidebar-nav navbar-collapse">
				<ul class="nav" id="side-menu">
					<li class="sidebar-search">
						<div class="input-group custom-search-form">
							<input type="text" class="form-control" placeholder="Search...">
							<span class="input-group-btn">
								<button class="btn btn-default" type="button">
									<i class="fa fa-search"></i>
								</button>
							</span>
						</div> <!-- /input-group -->
					</li>
					<li><a href="#"><i class="fa fa-dashboard fa-fw"></i>Cập
							nhật bài hát<span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="pageSource.html">Cập nhật link Mp3</a></li>
							<li><a href="pageSource.html">Cập nhật link img</a></li>
							<li><a href="pageSource.html">Cập nhật link lyric</a></li>
						</ul> <!-- /.nav-second-level --></li>

					<li><a href="#"><i class="fa fa-sitemap fa-fw"></i>Cập
							nhật Account<span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="pageSource.html">Thêm Account</a></li>
							<li><a href="pageSource.html">Xóa Account</a></li>
							<li><a href="pageSource.html">Sửa Account</a></li>
						</ul> <!-- /.nav-second-level --></li>
					<li><a href="#"><i class="fa fa-table fa-fw"></i>Cập nhật
							các bảng<span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="pageSource.html">Bảng 1</a></li>
							<li><a href="pageSource.html">Bảng 2</a></li>
							<li><a href="pageSource.html">Bảng 3</a></li>
						</ul> <!-- /.nav-second-level --></li>

					<li><a href="#"><i class="fa fa-bar-chart-o fa-fw"></i>Thống
							kê<span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="pageSource.html">Lịch sử dowload Mp3</a></li>
							<li><a href="pageSource.html">Lịch sử dowload img</a></li>
							<li><a href="pageSource.html">Lịch sử dowload lyric</a></li>
						</ul> <!-- /.nav-second-level --></li>

				</ul>
			</div>
			<!-- /.sidebar-collapse -->
		</div>
		<!-- /.navbar-static-side --> </nav>
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12 col-md-12">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<div class="row">
								<div class="col-xs-2">
									<i class="fa fa-users fa-5x"></i>
								</div>
								<div class="col-xs+4 text-left">
									<div class="huge">USER</div>
									<div></div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Danh sách người dùng</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>


			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">DataTables Advanced Tables</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<table width="100%"
								class="table table-striped table-bordered table-hover"
								id="dataTables-example">
								<thead>
									<tr>
										<th>Tài khoản</th>
										<th>Mật khẩu</th>
										<th>mail</th>
										<th>type</th>
										<th>name</th>
										<th colspan="2" align="center">
											<a href="pageInsertAccount.jsp">
											<button type="button" class="btn btn-primary">
												<i class="fa fa-bitbucket"> INSERT </i>
											</button>
											</a>
										</th>
									</tr>
								</thead>
								<tbody>
									<%
										int offset = 0;
										String index = request.getParameter("index");
										if (index != null) {
											offset = Integer.parseInt(index);
										}
										ArrayList<Account> arrayList = Account.AC_get_list_item(offset);
										for (Account account : arrayList) {
									%>
									<tr class="odd gradeX">
										<td class="center"><%=account.AC_get_id()%></td>
										<td class="center"><%=account.AC_get_passwd()%></td>
										<td class="center"><%=account.AC_get_mail()%></td>
										<td class="center"><%=account.AC_get_facebook()%></td>
										<td class="center"><%=account.AC_get_name()%></td>
										<td class="center">
											<button name="btedit" type="submit" class="btn btn-primary">
												<i class="fa  fa-edit  "> EDIT </i>
											</button>

										</td>
										<td class="center">
											<button name="btdelete" type="submit" class="btn btn-primary">
												<i class="fa fa-bitbucket"> DELETE </i>
											</button>

										</td>
									</tr>
									<%
										}
									%>
								</tbody>
							</table>
							<!-- /.table-responsive -->
							<%
							String urlNext = null;
							urlNext = "pageUser.jsp?index=" + (offset + 1);
							String urlPri = null;
							urlPri = "pageUser.jsp?index=" + (((offset) > 0) ? (offset - 1) : 0);
							%>
								<a href="<%=urlPri %>"><button type="button" class="btn btn-primary">Prious</button></a>
								<a href="#"><button type="button" class="btn btn-primary"><%=offset%></button></a>
								<a href="<%=urlNext%>"><button type="button" class="btn btn-primary">Next</button></a>

						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /#page-wrapper -->

		</div>
		<!-- /#wrapper -->

		<!-- jQuery -->
		<script src="JS/jquery.min.js"></script>

		<!-- Bootstrap Core JavaScript -->
		<script src="JS/bootstrap.min.js"></script>

		<!-- Metis Menu Plugin JavaScript -->
		<script src="JS/metisMenu.min.js"></script>

		<!-- Morris Charts JavaScript -->
		<script src="JS/raphael.min.js"></script>
		<script src="JS/morris.min.js"></script>
		<script src="JS/morris-data.js"></script>


		<!-- DataTables JavaScript -->
		<script src="JS/jquery.dataTables.min.js"></script>
		<script src="JS/dataTables.bootstrap.min.js"></script>
		<script src="JS/dataTables.responsive.js"></script>

		<!-- Custom Theme JavaScript -->
		<script src="JS/sb-admin-2.js"></script>
		<div>
			<div class="row">
				<div class="col-lg-12 col-md-12">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<div class="row">
								<div class="col-xs-12 text-center">
									<div>YAMATEAM - KTPM4 - K9 - HAUI</div>
									<div class="col-xs-12">
										<i>Hoàng Văn Nam : <i class="fa fa-phone fa-1x">1234567890</i>
											<i class="fa fa-envelope fa-1x"> mailmailmail@mail.mail |</i></i>
										<i>Mai Quang Diệu : <i class="fa fa-phone fa-1x">
												1234567890</i> <i class="fa fa-envelope fa-1x">
												mailmailmail@mail.mail |</i></i> <i>Nguyễn Việt Dũng : <i
											class="fa fa-phone fa-1x">1234567890</i> <i
											class="fa fa-envelope fa-1x"> mailmailmail@mail.mail</i></i>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
</body>

</html>
