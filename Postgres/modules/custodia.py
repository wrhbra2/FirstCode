import pandas as pd
import relatorios as rl
from flask import Flask, render_template
import psycopg2


def custodia():
    conn = rl.get_db_connection()
        
    global cust
    
    cust = pd.read_sql_query('select * from compra;',conn).set_index('id')
    
    
    return render_template('compra.html',cust=cust)
global cust



    
  