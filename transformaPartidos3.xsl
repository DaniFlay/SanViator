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
	background-color:#199403;
	color:white;
	padding:0.5em;
	font-family:Arial, Helvetica, sans-serif;
}
td{
	padding:0.5em;
	text-align:center;
	font-family: "Lucida Console", "Courier New", monospace;
}
tr:nth-child(odd){
	background-color:#a8a8a8;
}
tr:nth-child(even){
	background-color:white;
}
#realmadrid{
	background-color:#ffb300;
}

</style>
</head>
<body>
	<table class ="center" border="1"><thead>
			<th>Jornada</th>
			<th>Fecha</th>
			<th>Equipo Local</th>
			<th>Resultado</th>
			<th>Equipo Visitante</th>
	</thead>
	<tbody>
		<xsl:for-each select="partidos/partido">
		<xsl:choose>
		<xsl:when test= "contains(./EquipoLocal,'Real Madrid') or contains(./EquipoVisitante,'Real Madrid')">
		<tr id="realmadrid">
				<td><xsl:value-of select="Ronda"/></td>
				<td><xsl:value-of select="Fecha"/></td>	
				<td><xsl:value-of select="EquipoLocal"/></td>
				<td><xsl:value-of select="Resultado"/></td>	
				<td><xsl:value-of select="EquipoVisitante"/></td>
		</tr>
		</xsl:when>
		<xsl:otherwise>
			<tr>
				<td><xsl:value-of select="Ronda"/></td>
				<td><xsl:value-of select="Fecha"/></td>	
				<td><xsl:value-of select="EquipoLocal"/></td>
				<td><xsl:value-of select="Resultado"/></td>	
				<td><xsl:value-of select="EquipoVisitante"/></td>
		</tr>
		</xsl:otherwise>
		</xsl:choose>	
		</xsl:for-each>
	</tbody>
	</table>
</body>
</html>
</xsl:template>
</xsl:stylesheet>