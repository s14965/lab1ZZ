<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <div id="parent">
        <div id="formularz">
            <div style="margin: 10px;">
                <form action="url" method="POST">
                    <div>
                        <h2 style="width: 300px;">Formularza do wyliczania harmonogramu rat kredytu</h2>
                        <h4>Kwota kredytu</h6>
                        <input type="number" name="kwota" placeholder="Kwota np. 100000" /><br/>
                        <h4>Ilość rat</h4>
                        <input type="number" name="iloscRat" placeholder="Ilość rat np. 12" /><br/>
                        <h4>Oprocentowanie</h4>
                        <input type="number" name="oprocentowanie" placeholder="Oprocentowanie np. 3,5" /><br/>
                        <h4>Opłata stała</h4>
                        <input type="number" name="stala" placeholder="Opłata stała" /><br/>
                        <h4>Rodzaj raty</h4>
                        <select name="rodzajRaty">
                            <option value="malejaca">Malejąca</option>
                            <option value="stala">Stała</option>
                        </select><br/><br/>
                        <input id="but" type="submit" value="Oblicz harmonogram spłaty kredytu" />
                    </div>
                </form>
            </div>    
            <div>

            </div>
        </div>
    </div>
</body>
</html>


<style type="text/css">

    body 
    {
        position: absolute; 
        height: 100%; 
        width: 100%;
    }
    
    div 
    {
        text-align: center;
    }
    
    div#parent
    {
        width: 100%;
        height: 100%;
        display: flex;
        align-items: center; /* horizontal */
        justify-content: center; /* vertical */
    }
    
    div#formularz
    {
        margin: auto;
        justify-content: center; /* vertical */
        background-color: lightskyblue;
    }
    
    h1,h2,h3,h4,h5,h6
    {
        text-align: center;
    }
    input
    {
        text-align: center;
    }
    
    input#but
    {
        background-color: lightcoral;
        border: 1px;
        width: 70%;
        height: 40px;
    }
    
</style>
    