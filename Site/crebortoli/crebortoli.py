import psycopg2
from flask import Flask, render_template, url_for,request, redirect,flash
import pandas as pd



#Função init_py Flask.
app = Flask(__name__)
app.run(debug=True)
app.config['SECRET_KEY'] = 'admin'


def get_db_connection():
    # Criando conexão no banco.
    conn = psycopg2.connect(host='localhost',
                            database='postgres',
                            user='root',
                            password='postgres')
    #Espelhando.
    return conn



@app.route('/')
def index():
    return render_template('index.html')

@app.route('/agenda', methods=['GET','POST'])
def agenda():
    if request.method =='POST':
        #Abrir conexão
        conn = get_db_connection()
        cur = conn.cursor()
        
            
        #inputs usuario
        nome = request.form['nome']
        email = request.form['email']
        telefone = request.form['telefone']
        dia = request.form['dia']
        hora = request.form['hora']
        mensagem = request.form['msg']
        
        #Escrever query
        cur.execute(f"insert into agenda (nome, email, telefone, dia, hora, mensagem) values ('{nome}','{email}','{telefone}','{dia}','{hora}','{mensagem}');")
                        
        #Fechar conexão
        cur.commit()

        flash ('Agendado com Sucesso')

        conn.close()
        
        #Saida.
        return redirect(url_for('index'))
    return render_template('agenda.html')


@app.route('/admin', methods=['GET','POST'])
def admin():
    if request.method=='POST':
        #abrir conexão
        conn = get_db_connection()
        
        
        #realizar query
        post = pd.read_sql_query("select * from agenda;",conn)
        print(post)
        
            
        #fechar conexão
        conn.close()
        
        return redirect(url_for('admin'))
    return render_template('admin.html',post=post)


if __name__=='__main__':
    app.run(debug=True)
