import psycopg2
#Gerando conexão e bamco de dados padrão

connection = psycopg2.connect(dbname='postgres', user='root', password='postgres')
                          

cur = connection.cursor()

with open("tabela.sql") as arquivo:
    cur.execute(arquivo.read())

print('Neste ponto: A tabela AGENDA foi criada com sucesso.')

cur.execute("insert into agenda (nome, email, telefone, dia, hora, mensagem) values ('Morena Iluminada','morena@internet.com.br','14 990001010','31-01-2022','15:30','Depilação de pernas e virilha. Você é minha depiladora favorita!!!')")
print('Amostra de cadastro em AGENDA gravado com sucesso')

arquivo.close()
connection.commit()
connection.close()
