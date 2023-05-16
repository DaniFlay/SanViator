<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html"/>
<xsl:template match="/">
<html>
<head>
<style>
.special{
background-color:#70fa91
}
.other{
background-color:#86b3f7
}
.center{
margin-left:auto
margin-right:auto

}
table{border-collapse:collapse;
margin:auto;}
th{
background-color:#4521d9
}
td{text-align:center}
</style>
</head>
<body>
<table class="center">
<thead>
<th>Nombre</th>
<th>Plataforma</th>
<th>Fecha de Salida</th>
<th>Nota Metacritic</th>
<th>Nota de Usuarios</th>
</thead>
<tbody>
<xsl:for-each select="/juegos/juego">
<xsl:sort select="./notaMetacritic" order="descending"/>
<xsl:choose>
<xsl:when test="contains(./plataforma,'Wii') and number(./notaMetacritic) &gt; 89">
<tr class="special">
<td><xsl:value-of select="nombre"></xsl:value-of></td>
<td><xsl:value-of select="plataforma"></xsl:value-of></td>
<td><xsl:value-of select="fechaSalida"></xsl:value-of></td>
<td><xsl:value-of select="notaMetacritic"></xsl:value-of></td>
<td><xsl:value-of select="notaUsuarios"></xsl:value-of></td>
</tr>
</xsl:when>
<xsl:otherwise>
<tr class="other">
<td><xsl:value-of select="nombre"></xsl:value-of></td>
<td><xsl:value-of select="plataforma"></xsl:value-of></td>
<td><xsl:value-of select="fechaSalida"></xsl:value-of></td>
<td><xsl:value-of select="notaMetacritic"></xsl:value-of></td>
<td><xsl:value-of select="notaUsuarios"></xsl:value-of></td>
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
