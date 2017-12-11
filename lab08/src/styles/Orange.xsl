<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <body>
                <h2>Special Offer</h2>
                <table border="1">
                    <tr bgcolor="orange">
                        <th>id</th>
                        <th>name</th>
                        <th>manufacturer</th>
                        <th>description</th>
                        <th>price</th>
                    </tr>
                    <tr>
                        <td><xsl:value-of select="offer/id"/></td>
                        <td><xsl:value-of select="offer/name"/></td>
                        <td><xsl:value-of select="offer/manufacturer"/></td>
                        <td><xsl:value-of select="offer/description"/></td>
                        <td><xsl:value-of select="offer/price"/></td>
=                    </tr>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>