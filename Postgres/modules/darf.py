import pandas as pd
import relatorios as rl
from flask import Flask, render_template
import psycopg2


def darf():
    conn = rl.get_db_connection()
        
    global darf
    query =  "select id,ref,classe,ativo,quant,preco,(quant*preco ) as total from venda;"
    #query2 = 'select total (total>2000=total*0.15)as darf from vendas;'
    
    conn.execute = "alter table venda add column darf money as (total*0.15) stored;"
            
    darf = pd.read_sql_query(query,conn).set_index('id')
   
    
        
    return render_template('venda.html',darf=darf)







    
  