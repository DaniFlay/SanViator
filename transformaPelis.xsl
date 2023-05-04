<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html"/>
<xsl:template match="/">
<html>
<head>
<style>
.center {
  margin-left: auto;
  margin-right: auto;
}
th{
	background-color:#00F4DE;
	color:white;
	padding:0.5em;
	font-family:Arial, Helvetica, sans-serif;
}
td{
	padding:0.5em;
	text-align:center;
	font-family: "Lucida Console", "Courier New", monospace;
}
.nueve{
	background:#196800;
}
.ochonueve{
	background:#3EFF00;
}	
.sieteocho{
background:#0018C7;
color:white;
}
.seissiete{
background:#FF9F0B;
color:white;
}
.cincoseis{
background:#ECFF00;
}
.cinco{
background:#FF0000;
}
</style>
</head>
<body>
	<table class ="center" border="1"><thead>
			<th>Titulo</th>
			<th>Fecha de Lanzamiento</th>
			<th>Duracion</th>
			<th>Puntuacion</th>
	</thead>
	<tbody>
		<xsl:for-each select="films/film[contains(./Language,'English') or contains(./Language,'Spanish')]">
			<xsl:sort select="./IMDBScore" order="descending"/>
				<xsl:if test="./IMDBScore &gt;= 9">
					<tr class="nueve">
						<td><xsl:value-of select="Title"/></td>
						<td><xsl:value-of select="Premiere"/></td>
						<td><xsl:value-of select="Runtime"/></td>				
						<td><xsl:value-of select="IMDBScore"/></td>
					</tr>
				</xsl:if>
				<xsl:if test="./IMDBScore &gt;= 8 and ./IMDBScore &lt; 9">
					<tr class="ochonueve">
						<td><xsl:value-of select="Title"/></td>
						<td><xsl:value-of select="Premiere"/></td>
						<td><xsl:value-of select="Runtime"/></td>				
						<td><xsl:value-of select="IMDBScore"/></td>
					</tr>
				</xsl:if>						
				<xsl:if test="./IMDBScore &gt;= 7 and ./IMDBScore &lt; 8">
					<tr class="sieteocho">
						<td><xsl:value-of select="Title"/></td>
						<td><xsl:value-of select="Premiere"/></td>
						<td><xsl:value-of select="Runtime"/></td>				
						<td><xsl:value-of select="IMDBScore"/></td>
					</tr>
				</xsl:if>
				<xsl:if test="./IMDBScore &gt;= 6 and ./IMDBScore &lt; 7">
					<tr class="seissiete">
						<td><xsl:value-of select="Title"/></td>
						<td><xsl:value-of select="Premiere"/></td>
						<td><xsl:value-of select="Runtime"/></td>				
						<td><xsl:value-of select="IMDBScore"/></td>
					</tr>
				</xsl:if>
				<xsl:if test="./IMDBScore &gt;= 5 and ./IMDBScore &lt; 6">
					<tr class="cincoseis">
						<td><xsl:value-of select="Title"/></td>
						<td><xsl:value-of select="Premiere"/></td>
						<td><xsl:value-of select="Runtime"/></td>				
						<td><xsl:value-of select="IMDBScore"/></td>
					</tr>
				</xsl:if>
				<xsl:if test="./IMDBScore &lt; 5">
					<tr class="cinco">
						<td><xsl:value-of select="Title"/></td>
						<td><xsl:value-of select="Premiere"/></td>
						<td><xsl:value-of select="Runtime"/></td>				
						<td><xsl:value-of select="IMDBScore"/></td>
					</tr>
				</xsl:if>
		</xsl:for-each>	
	</tbody>
	</table>
</body>
</html>
</xsl:template>
</xsl:stylesheet>