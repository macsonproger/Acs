<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" omit-xml-declaration="yes"/>
    <xsl:template match="/">
        <html>
            <body>
                <h1>Игры</h1>
                <table>
                    <tr>
                        <th>id</th>
                        <th>Название</th>
                        <th>Разработчик</th>
                    </tr>
                    <xsl:apply-templates/>
                </table>
            </body>
        </html>
    </xsl:template>
    <xsl:template match="game">
        <tr>
            <td>
                <xsl:value-of select="@id"/>
            </td>
            <td>
                <xsl:value-of select="@tittle"/>
            </td>
            <td>
                <xsl:value-of select="@dev_id"/>
            </td>

        </tr>
    </xsl:template>
</xsl:stylesheet>