import re
from flask import Flask, url_for, request, redirect, render_template, flash
from matplotlib.backend_bases import RendererBase
from sqlalchemy import create_engine
from sqlalchemy.orm import scoped_session, sessionmaker
import psycopg2
import pandas as pd
import numpy as np
import custodia as cs



app = Flask(__name__)
app.run(debug = True)
app.config['SECRET_KEY'] = 'admin'

def get_db_connection():
    # Criando conexão no banco.
    global conn
    
    conn = create_engine("postgresql://root:postgres@localhost:5432/postgres")
    
    global session
    session = scoped_session(sessionmaker(bind=conn))
    
    #Espelhando.
    return conn

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/orcamento', methods=['GET','POST'])
def orcamento():
    if request.method == 'POST':
        conn = get_db_connection()
        
        descricao = request.form['descricao']
        preco = request.form['preco']
        
        conn.execute(f"insert into orcamento (descricao, preco) values ('{descricao}', '{preco}');")
        
        session.commit()
        
        session.close()
        
        flash('Adicionado ao Orçamento.')
        return redirect(url_for('index'))
    return render_template('orcamento.html')

@app.route('/compra', methods=['GET','POST'])
def compra():
    try:
        if request.method == 'POST':
            conn = get_db_connection()
       
            classe = request.form['classe']
            ativo = request.form['ativo']
            quant = request.form['quant']
            preco = request.form['preco']
            
            if (classe,ativo,quant,preco) is None:
                flash 

            conn.execute(f"insert into compra (classe, ativo, quant, preco) values ('{classe}', '{ativo}','{quant}','{preco}');")

            session.commit()

            session.close()

            flash('Compra registrada.')

            return redirect(url_for('index'))
        return render_template('compra.html')
           
    except Exception:
        return render_template('error.html')
    finally:
        cs.custodia()
        cust = cs.cust
        flash('Carteira ATUALIZADA!')
        return render_template('compra.html',cust=cust)
              
        
        

@app.route('/venda', methods=['GET','POST'])
def venda():
    if request.method == 'POST':
        conn = get_db_connection()
       
        classe = request.form['classe']
        ativo = request.form['ativo']
        quant = request.form['quant']
        preco = request.form['preco']

        conn.execute(f"insert into venda (classe, ativo, quant, preco) values ('{classe}','{ativo}','{quant}','{preco}');")

        session.commit()

        session.close()

        flash('Venda Realizada.')

        return redirect(url_for('index'))
    return render_template('venda.html')

@app.route('/proventos',methods=['GET','POST'])
def proventos():
    if request.method == 'POST':
        conn = get_db_connection()
        
        classe = request.form['classe']
        ativo = request.form['ativo']
        quant = request.form['quant']
        valor = request.form['valor']

        conn.execute(f"insert into proventos (classe, ativo, quant, valor) values ('{classe}','{ativo}','{quant}','{valor}');")

        session.commit()

        session.close()

        flash('Seus créditos foram registrados.')
        
        return redirect(url_for('index'))
    return render_template('proventos.html')
    

@app.route('/agenda',methods=['GET','POST'])
def agenda():
    
    if request.form == 'POST':
        conn = get_db_connection()
    
        org = request.form['organizacao']
        ident = request.form['identidade']
        sen = request.form['senha']
        obs = request.form['observacoes']
        
        pd.read_sql_table(f"insert into agenda (organizacao, identidade, senha, observacoes) values ('{org}','{ident}','{sen}', '{obs}');",conn)
        
        session.commit()
        
        session.close()
        
        flash('Identidade registrada.')
        
        return redirect(url_for('index'))
    return render_template('agenda.html')

@app.route('/fisco')
def fisco():
    conn = get_db_connection()
    
    conf = pd.read_sql_query("select * from compra, venda",conn)
    
     
    return render_template('fisco.html',conf=conf)

@app.route('/error')
def error():
    return render_template('error.html')