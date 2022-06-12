from csv import writer
import pandas as pd
import relatorios as rl
from flask import Flask, render_template
import psycopg2


def custodia():
    conn = rl.get_db_connection()
        
    global cust
    query =  "select * from relatorios.compra;"
       
    c = pd.read_sql_query(query,conn).set_index('id')
    
    def style_line():
    #Rendering odd and even rows with different color'''
     return ['background-color: #D4E6F1' if i%2!=0 else 'background-color: #85C1E9' for i in range(len(s))]

    cust = c.to_html()
    
    
    
    
        
    return render_template('compra.html', cust=cust)





    
  