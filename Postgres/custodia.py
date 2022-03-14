import pandas as pd
import relatorios as rl
from flask import Flask, render_template
import psycopg2


def custodia():
    conn = rl.get_db_connection()
    
    c = rl.conn.execute('select * from compra;')
    global cust
    cust = c.fetchone()
    print('resultado da função custodia',cust)
    
    
    return render_template('compra.html',cust=cust)
global cust



    
  