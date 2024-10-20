## Filter Service

Filter service allows you to filter cars by brand, model, and year.

<table>
    <thead>
        <tr>
            <th></th>
            <th>Filters</th>
        </tr>
    </thead>
    <tbody>
        <code>http://[host]:[port]/wheelsondemand/filter/api/filters</code>
        <tr>
            <td>$\textcolor{cornflowerblue}{GET}$</td>
            <td>/filters/car?carName={carName}</td>
        </tr>
        <tr>
            <td>$\textcolor{cornflowerblue}{GET}$</td>
            <td>/filters/brand?brandName={brandName}</td>
        </tr>
        <tr>
            <td>$\textcolor{cornflowerblue}{GET}$</td>
            <td>/filters/model?modelName={modelName}</td>
        </tr>
        <tr>
            <td>$\textcolor{cornflowerblue}{GET}$</td>
            <td>/filters/brand/all</td>
        </tr>
        <tr>
            <td>$\textcolor{cornflowerblue}{GET}$</td>
            <td>/filters/car/all</td>
        </tr>
        <tr>
            <td>$\textcolor{cornflowerblue}{GET}$</td>
            <td>/filters/model/all</td>
        </tr>
    </tbody>
</table>
