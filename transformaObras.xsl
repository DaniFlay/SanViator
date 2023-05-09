<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html"/>
<xsl:template match="/">
<html>
<head>
<style>
th{
	background-color:#1E7B05;
	color:white;
	padding:0.5em;
}
td{
	padding:0.5em;
}

.blueColor{
	color:blue;
	}
.españa{
	background:#fc0303;
}
.otrosPaises{
	background:#e0c95e;
}	
</style>
</head>
<body>
	<table border="1"><thead>
			<th>Titulo</th>
			<th>Autor</th>
			<th>Museo</th>
			<th>Pais</th>
			<th>Año</th>
	</thead>
	<tbody>
		<xsl:for-each select="obras/obra">
			<xsl:sort select="@anyo" order="ascending"/>
			<xsl:choose>
				<xsl:when test="@pais='España'">
					<tr class="españa">
						<td><xsl:value-of select="titulo"/></td>
						<td><xsl:value-of select="autor"/></td>
						<td><xsl:value-of select="museo"/></td>				
						<td><xsl:value-of select="@pais"/></td>
						<td><xsl:value-of select="@anyo"/></td>
					</tr>
				</xsl:when>
				<xsl:otherwise>
					<tr class="otrosPaises">
						<td><xsl:value-of select="titulo"/></td>
						<td><xsl:value-of select="autor"/></td>
						<td><xsl:value-of select="museo"/></td>				
						<td><xsl:value-of select="@pais"/></td>
						<td><xsl:value-of select="@anyo"/></td>
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
