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
	background-color:#b700fa;
	color:white;
	padding:0.5em;
	font-family:Arial, Helvetica, sans-serif;
}
td{
	padding:0.5em;
	text-align:center;
	font-family: "Lucida Console", "Courier New", monospace;
	background:#00FFFF;
}
</style>
</head>
<body>
	<table class ="center" border="1"><thead>
			<th>Titulo</th>
			<th>Titulo Original</th>
			<th>Puntuacion</th>
			<th>Anyo</th>
	</thead>
	<tbody>
		<xsl:for-each select="peliculas/pelicula">
			<xsl:sort select="./puntuacion" order="descending"/>
					<tr>
						<td><xsl:value-of select="titulo"/></td>
						<td><xsl:value-of select="tituloOriginal"/></td>	
						<td><xsl:value-of select="puntuacion"/></td>
						<td><xsl:value-of select="anyo"/></td>			
					</tr>
		</xsl:for-each>	
	</tbody>
	</table>
</body>
</html>
</xsl:template>
</xsl:stylesheet>