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
.francia{
	background:#394dfa;
}	
.paisesBajos{
background:#e87e20;
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
		<xsl:for-each select="obras/obra[./museo/@visible='true']">
			<xsl:sort select="@anyo" order="ascending"/>
				<xsl:if test="@pais='España'">
					<tr class="españa">
						<td><xsl:value-of select="titulo"/></td>
						<td><xsl:value-of select="autor"/></td>
						<td><xsl:value-of select="museo"/></td>				
						<td><xsl:value-of select="@pais"/></td>
						<td><xsl:value-of select="@anyo"/></td>
					</tr>
				</xsl:if>
				<xsl:if test="@pais='Francia'">
					<tr class="francia">
						<td><xsl:value-of select="titulo"/></td>
						<td><xsl:value-of select="autor"/></td>
						<td><xsl:value-of select="museo"/></td>				
						<td><xsl:value-of select="@pais"/></td>
						<td><xsl:value-of select="@anyo"/></td>
					</tr>
				</xsl:if>						
				<xsl:if test="@pais='Paises bajos'">
					<tr class="paisesBajos">
						<td><xsl:value-of select="titulo"/></td>
						<td><xsl:value-of select="autor"/></td>
						<td><xsl:value-of select="museo"/></td>				
						<td><xsl:value-of select="@pais"/></td>
						<td><xsl:value-of select="@anyo"/></td>
					</tr>
				</xsl:if>
		</xsl:for-each>	
	</tbody>
	</table>
</body>
</html>
</xsl:template>
</xsl:stylesheet>
