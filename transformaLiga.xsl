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
}
tr:nth-child(odd){
	background:#ccff33;
}
tr:nth-child(even){
	background:#ff6666;
}
#champions{
	background:#22de09;
}
#europaleague{
	background:#0000FF;
}	
#clasfel{
background:#00FFFF;
color:white;
}
#descenso{
background:#FF0000;
}
#resto{
background:white;
}
</style>
</head>
<body>
	<table class ="center" border="1"><thead>
			<th>Puesto</th>
			<th>Nombre</th>
			<th>Puntos</th>
			<th>Partidos Ganados</th>
			<th>Partidos Empatados</th>
			<th>Partidos Perdidos</th>
			<th>Goles a Favor</th>
			<th>Goles en Contra</th>
	</thead>
	<tbody>
		<xsl:for-each select="clasificacion/equipo">
				<xsl:if test="./puesto = 1 or ./puesto = 2 or ./puesto = 3 or ./puesto = 4">
					<tr id="champions">
						<td><xsl:value-of select="puesto"/></td>
						<td><xsl:value-of select="nombre"/></td>
						<td><xsl:value-of select="puntos"/></td>				
						<td><xsl:value-of select="partidosGanados"/></td>
						<td><xsl:value-of select="partidosEmpatados"/></td>
						<td><xsl:value-of select="partidosPerdidos"/></td>
						<td><xsl:value-of select="golesFavor"/></td>				
						<td><xsl:value-of select="golesContra"/></td>
					</tr>
				</xsl:if>
				<xsl:if test="./puesto = 5 or ./puesto = 6">
					<tr id="europaleague">
						<td><xsl:value-of select="puesto"/></td>
						<td><xsl:value-of select="nombre"/></td>
						<td><xsl:value-of select="puntos"/></td>				
						<td><xsl:value-of select="partidosGanados"/></td>
						<td><xsl:value-of select="partidosEmpatados"/></td>
						<td><xsl:value-of select="partidosPerdidos"/></td>
						<td><xsl:value-of select="golesFavor"/></td>				
						<td><xsl:value-of select="golesContra"/></td>
					</tr>
				</xsl:if>						
				<xsl:if test="./puesto = 7">
					<tr id="clasfel">
						<td><xsl:value-of select="puesto"/></td>
						<td><xsl:value-of select="nombre"/></td>
						<td><xsl:value-of select="puntos"/></td>				
						<td><xsl:value-of select="partidosGanados"/></td>
						<td><xsl:value-of select="partidosEmpatados"/></td>
						<td><xsl:value-of select="partidosPerdidos"/></td>
						<td><xsl:value-of select="golesFavor"/></td>				
						<td><xsl:value-of select="golesContra"/></td>
					</tr>
				</xsl:if>
				<xsl:if test="./puesto = 18 or ./puesto = 19 or ./puesto = 20 ">
					<tr id="descenso">
						<td><xsl:value-of select="puesto"/></td>
						<td><xsl:value-of select="nombre"/></td>
						<td><xsl:value-of select="puntos"/></td>				
						<td><xsl:value-of select="partidosGanados"/></td>
						<td><xsl:value-of select="partidosEmpatados"/></td>
						<td><xsl:value-of select="partidosPerdidos"/></td>
						<td><xsl:value-of select="golesFavor"/></td>				
						<td><xsl:value-of select="golesContra"/></td>
					</tr>
				</xsl:if>
				<xsl:if test="./puesto = 8 or ./puesto = 9 or ./puesto = 10 or ./puesto = 11 or ./puesto = 12 or ./puesto = 13 or ./puesto = 14 or ./puesto = 15 or ./puesto = 16 or ./puesto = 17">
					<tr>
						<td><xsl:value-of select="puesto"/></td>
						<td><xsl:value-of select="nombre"/></td>
						<td><xsl:value-of select="puntos"/></td>				
						<td><xsl:value-of select="partidosGanados"/></td>
						<td><xsl:value-of select="partidosEmpatados"/></td>
						<td><xsl:value-of select="partidosPerdidos"/></td>
						<td><xsl:value-of select="golesFavor"/></td>				
						<td><xsl:value-of select="golesContra"/></td>
					</tr>
				</xsl:if>
		</xsl:for-each>	
	</tbody>
	</table>
	<table class ="center" border="1">
	<tbody>
		<tr id='champions'>
			<td>Champions</td>
		</tr>
		<tr id='europaleague'>
			<td>Europa League</td>
		</tr>
		<tr id='clasfel'>
			<td>Clasificacion Europa League</td>
		</tr>
		<tr id='descenso'>
			<td>Descenso</td>
		</tr>
	</tbody>	
	</table>
</body>
</html>
</xsl:template>
</xsl:stylesheet>