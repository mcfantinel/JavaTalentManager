<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<html>
  <body>
    <div id="pageheader">
      <div id="header">
		<div>
			<div class="logo">
				<a href="#">Online Test</a>
			</div>
			<ul id="navigation">
				<li class="active"><a href="home.html">Home</a></li>
				<li><a href="about.html">About</a></li>
				<li><a href="contact.html">Contact</a></li>
			</ul>
		</div>
	</div>
    </div>
    <div id="body">
      <jsp:doBody/>
    </div>
    <div id="pagefooter">
      <div id="footer">
		<div class="clearfix">
			<div id="connect">
				<a href="#" target="_blank" class="facebook"></a> <a href="#"
					target="_blank" class="googleplus"></a> <a href="#" target="_blank"
					class="twitter"></a>
			</div>
			<p>© 9999 Online Test. No Rights Reserved.</p>
		</div>
	</div>
    </div>
  </body>
</html>