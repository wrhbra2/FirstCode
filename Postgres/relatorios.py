from flask import Flask, url_for, redirect, render_template, flash, request
from matplotlib.backend_bases import RendererBase
from sqlalchemy import create_engine
from sqlalchemy.orm import scoped_session, sessionmaker
import psycopg2
import pandas as pd
import numpy as np
from modules import custodia as cs
from modules import darf as df
from modules import rentabilidade as rt


app = Flask(__name__)
app.config['SECRET_KEY'] = 'admin'

def get_db_connection():
    # Criando conexão no banco.
    global conn
    
    #sintaxe "postgresql://user:senha@host:porta/database_base"
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
    if request.method =='POST':
        conn = get_db_connection()
        
        descricao = request.form['descricao']
        preco = request.form['preco']
        
        conn.execute(f"insert into relatorios.orcamento (descricao, preco) values ('{descricao}', '{preco}');")
        
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
                return render_template('error.html')
                

            conn.execute("insert into relatorios.compra (classe, ativo, quant, preco) values ('{classe}', '{ativo}','{quant}','{preco}' );")

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
    try:
        if request.method=='POST':
            conn = get_db_connection()
        
            classe = request.form['classe']
            ativo = request.form['ativo']
            quant = request.form['quant']
            preco = request.form['preco']

            conn.execute(f"insert into relatorios.venda (classe, ativo, quant, preco) values ('{classe}','{ativo}','{quant}','{preco}');")

            session.commit()

            session.close()

            flash('Venda Realizada.')

            return redirect(url_for('index'))
        return render_template('venda.html')
  
    except Exception:
        return render_template('error.html')
   
    finally:
         df.darf()
         darf = df.darf
         flash('Imposto CALCULADO!')
         return render_template('venda.html',darf=darf)
       
    

@app.route('/proventos',methods=['GET','POST'])
def proventos():
    if request.method=='POST':
        conn = get_db_connection()
        
        classe = request.form['classe']
        ativo = request.form['ativo']
        quant = request.form['quant']
        valor = request.form['valor']

        conn.execute(f"insert into relatorios.proventos (classe, ativo, quant, valor) values ('{classe}','{ativo}','{quant}','{valor}');")

        session.commit()

        session.close()

        flash('Seus créditos foram registrados.')
        
        return redirect(url_for('index'))
    return render_template('proventos.html')
    

@app.route('/fisco')
def fisco():
    conn = get_db_connection()
    
    conf = pd.read_sql_query("select * from relatorios.compra, relatrios.venda",conn)
         
    return render_template('fisco.html',conf=conf)

@app.route('/error')
def error():
    return render_template('error.html')

@app.route('/agenda',methods=['GET','POST'])
def agenda():
    if request.form == 'POST':
        conn = get_db_connection()
    
        org = request.form.get['organizacao']
        ident = request.form.get['identidade']
        sen = request.form.get['senha']
        obs = request.form.get['observacoes']
        
        print(org,ident,sen,obs)
        
        conn.execute(f"insert into relatorios.agenda (organizacao, identidade, senha, observacoes) values ('{org}','{ident}','{sen}', '{obs}');")
        
        session.commit()
        
        session.close()
        
        flash('Identidade registrada.')
        
        return redirect(url_for('index'))
    return render_template('agenda.html')
