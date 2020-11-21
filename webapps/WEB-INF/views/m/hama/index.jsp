<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>메인 - 모바일</title>
	<link rel="stylesheet" href="<%= contextPath %>/resources/js/jquery.mobile-1.4.5/css/themes/default/jquery.mobile-1.4.5.min.css">
	<link rel="stylesheet" href="<%= contextPath %>/resources/js/jquery.mobile-1.4.5/_assets/css/jqm-demos.css">
	<script src="<%= contextPath %>/resources/js/jquery.mobile-1.4.5/js/jquery.js"></script>
	<script src="<%= contextPath %>/resources/js/jquery.mobile-1.4.5/_assets/js/index.js"></script>
	<script src="<%= contextPath %>/resources/js/jquery.mobile-1.4.5/js/jquery.mobile-1.4.5.min.js"></script>
	<script id="popup-arrow-script">
	$.mobile.document.on( "click", "#open-popupArrow", function( evt ) {
		$( "#popupArrow" ).popup( "open", { x: evt.pageX, y: evt.pageY } );
		evt.preventDefault();
	});
	</script>
	<style id="popup-arrow-css">
	.clickable-area {
		display: block;
		width: 100%;
		height: 300px;
		background-color: #ffefef;
	}
	.clickable-area:focus {
		outline: 0;
	}
	</style>
	<style id="tooltip-btn">
	.ui-btn.my-tooltip-btn,
	.ui-btn.my-tooltip-btn:hover,
	.ui-btn.my-tooltip-btn:active {
		background: none;
		border: 0;
	}
	</style>
</head>
<body>

<!-- 모바일 페이지 -->
<div data-role="page" class="jqm-demos" data-quicklinks="true">
	
	<div data-role="header" style="background-color:#e2e2e2;">
    	<h1>로그인 - 예제(OpenSource)</h1>
  	</div>
	<!-- header(헤더) -->
	<div data-role="header" class="jqm-header" >
		<h2>
			<a href="../" data-ajax="false" title="jQuery Mobile Demos home">
				<img src="<%= contextPath %>/resources/js/jquery.mobile-1.4.5/_assets/img/jquery-logo.png" alt="jQuery Mobile">
			</a>
		</h2>
		<p><span class="jqm-version"></span> Demos</p>
		<a href="#" class="jqm-navmenu-link ui-btn ui-btn-icon-notext ui-corner-all ui-icon-bars ui-nodisc-icon ui-alt-icon ui-btn-left">Menu</a>
		<a href="#" class="jqm-search-link ui-btn ui-btn-icon-notext ui-corner-all ui-icon-search ui-nodisc-icon ui-alt-icon ui-btn-right">Search</a>
	</div>
	<!-- /header(헤더) -->

	<!-- Content(본문) -->
	<div role="main" class="ui-content jqm-content">
		<h1>Popup</h1>
		<p>The popup widget can be used for various types of popups. From a small tooltip popup to a large photo lightbox.</p>
		
		
		<ul data-role="listview" data-inset="true">
			<li data-role="list-divider">Friday, October 8, 2010 <span class="ui-li-count">2</span></li>
			<li><a href="index.html">
			<h2>Stephen Weber</h2>
			<p><strong>You've been invited to a meeting at Filament Group in Boston, MA</strong></p>
			<p>Hey Stephen, if you're available at 10am tomorrow, we've got a meeting with the jQuery team.</p>
				<p class="ui-li-aside"><strong>6:24</strong>PM</p>
			</a></li>
			<li><a href="index.html">
			<h2>jQuery Team</h2>
			<p><strong>Boston Conference Planning</strong></p>
			<p>In preparation for the upcoming conference in Boston, we need to start gathering a list of sponsors and speakers.</p>
				<p class="ui-li-aside"><strong>9:18</strong>AM</p>
			</a></li>
			<li data-role="list-divider">Thursday, October 7, 2010 <span class="ui-li-count">1</span></li>
			<li><a href="index.html">
			<h2>Avery Walker</h2>
			<p><strong>Re: Dinner Tonight</strong></p>
			<p>Sure, let's plan on meeting at Highland Kitchen at 8:00 tonight. Can't wait!</p>
				<p class="ui-li-aside"><strong>4:48</strong>PM</p>
			</a></li>
		</ul>
		
	</div>
	
	
	<!-- /Content(본문) -->
	
	<!-- NavMenu(메뉴) -->
	<div data-role="panel" class="jqm-navmenu-panel" data-position="left" data-display="overlay" data-theme="a">
    	<ul class="jqm-list ui-alt-icon ui-nodisc-icon">
			<li data-filtertext="demos homepage" data-icon="home"><a href=".././">Home</a></li>
			<li data-filtertext="introduction overview getting started">
				<a href="../intro/" data-ajax="false">Introduction</a>
			</li>
			<li data-role="collapsible" data-enhanced="true" data-collapsed-icon="carat-d" data-expanded-icon="carat-u" data-iconpos="right" data-inset="false" class="ui-collapsible ui-collapsible-themed-content ui-collapsible-collapsed">
				<h3 class="ui-collapsible-heading ui-collapsible-heading-collapsed">
					<a href="#" class="ui-collapsible-heading-toggle ui-btn ui-btn-icon-right ui-btn-inherit ui-icon-carat-d">
		    			Checkboxradio widget
		    			<span class="ui-collapsible-heading-status"> click to expand contents</span>
					</a>
				</h3>
				<div class="ui-collapsible-content ui-body-inherit ui-collapsible-content-collapsed" aria-hidden="true">
					<ul>
						<li data-filtertext="form checkboxradio widget checkbox input checkboxes controlgroups">
							<a href="../checkboxradio-checkbox/" data-ajax="false">
								Checkboxes
							</a>
						</li>
						<li data-filtertext="form checkboxradio widget radio input radio buttons controlgroups">
							<a href="../checkboxradio-radio/" data-ajax="false">
							Radio buttons
							</a>
						</li>
					</ul>
				</div>
			</li>
			<li data-role="collapsible" data-enhanced="true" data-collapsed-icon="carat-d" data-expanded-icon="carat-u" data-iconpos="right" data-inset="false" class="ui-collapsible ui-collapsible-themed-content ui-collapsible-collapsed">
				<h3 class="ui-collapsible-heading ui-collapsible-heading-collapsed">
					<a href="#" class="ui-collapsible-heading-toggle ui-btn ui-btn-icon-right ui-btn-inherit ui-icon-carat-d">
						Collapsible (set) widget
						<span class="ui-collapsible-heading-status"> click to expand contents</span>
					</a>
				</h3>
				<div class="ui-collapsible-content ui-body-inherit ui-collapsible-content-collapsed" aria-hidden="true">
					<ul>
						<li data-filtertext="collapsibles content formatting">
							<a href="../collapsible/" data-ajax="false">
								Collapsible
							</a>
						</li>
						<li data-filtertext="dynamic collapsible set accordion append expand">
							<a href="../collapsible-dynamic/" data-ajax="false">
								Dynamic collapsibles
							</a>
						</li>
						<li data-filtertext="accordions collapsible set widget content formatting grouped collapsibles">
							<a href="../collapsibleset/" data-ajax="false">
								Collapsible set
							</a>
						</li>
					</ul>
				</div>
			</li>
		</ul>
	</div>
	<!-- /panel -->

	<!-- 푸터 -->
	<div data-role="footer" data-position="fixed" data-tap-toggle="false" class="jqm-footer">
		<p>jQuery Mobile Demos version <span class="jqm-version"></span></p>
		<p>Copyright 2014 The jQuery Foundation</p>
	</div>
	<!-- /푸터 -->
	
	<!-- 검색 패널 -->
    <div data-role="panel" class="jqm-search-panel" data-position="right" data-display="overlay" data-theme="a">
		<div class="jqm-search">
		
			<ul class="jqm-list" data-filter-placeholder="Searchㅇ demos..." data-filter-reveal="true">
				<!-- 검색 필터 -->
				<li data-filtertext="demos homepage" data-icon="home">
					<a href=".././">Home</a>
				</li>
				<li data-filtertext="introduction overview getting started">
					<a href="../intro/" data-ajax="false">Introduction</a>
				</li>
				<li data-filtertext="buttons button markup buttonmarkup method anchor link button element">
					<a href="../button-markup/" data-ajax="false">Buttons</a>
				</li>
				
				<li data-filtertext="form button widget input button submit reset">
					<a href="../button/" data-ajax="false">Button widget</a>
				</li>
			</ul>
		</div>
	</div>
	<!-- /검색 패널 -->


</div><!-- /page -->

</body>
</html>
