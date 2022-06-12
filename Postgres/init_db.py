import relatorios as rl
import psycopg2

conn = rl.get_db_connection()



with open("tabelas.sql") as arquivo:
    conn.execute(arquivo.read())

print('Neste ponto, o SCHEMA relatorios foi criada com sucesso. A seguir as tabelas serão populadas.')


conn.execute("insert into relatorios.orcamento (descricao, preco) values ('mercado','10,00');")
print('Item adicionado com sucesso no orçamento')

conn.execute(f"insert into relatorios.compra (classe, ativo, quant, preco) values ('acoes','abcd3','2000','1,00');")
print('Compra registrada')

conn.execute("insert into relatorios.venda (classe, ativo, quant, preco) values ('acoes','abcd3','2000','10,00');")
print('Venda registrada')

conn.execute("insert into relatorios.proventos (classe, ativo, quant, valor) values ('acoes','abcd3','2000','10,00');")
print('proventos registrada')

conn.execute("insert into relatorios.agenda (organizacao, identidade, senha, observacoes) values ('banco local','monero23XX','@123456789abcd#$!@&*','conta corrent 23XX 1 agencia 00');")
print('agenda registrada')

arquivo.close()
rl.session.commit()
rl.session.close()

