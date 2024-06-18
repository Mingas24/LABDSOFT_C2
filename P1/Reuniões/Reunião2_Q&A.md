# Reunião 2 - Q&A

## Informático:

### Confidencialidade dos dados e automatização dos processos, evitando redundância de dados. Como funcionam os equipamentos. O departamento de inovação tem ideias que vão influenciar o projeto.

**Os orgãos/recetores encontram-se afiliados a alguma unidade hospitalar, ou seja, existe um Excel por unidade hospitalar com esses dados ou é centralizado? Se sim, como?**  
**R:** Template do Excel do registo das análises. Existe uma rede interna com os ficheiros Excel. Cada utente tem um Excel (pedir ao médico/enfermeiro os templates).

**Que recursos tem para alojamento? Deseja um alojamento físico ou em Cloud?**  
**R:** Indecisos entre Cloud/Físico

**Deseja um software ou/e website ou/e app mobile?**  
**R:** Análise interna (ainda não definido)

**Existe algum software interno que tenha de ser integrado no novo software? Se sim, qual será o meio desejado para interligar as diferentes plataformas?**  
**R:** Integração com equipamentos (a equipa de desenvolvimento ainda não sabe como é feita a interligação com os equipamentos e o sistema a desenvolver)

**Quantas roles existem e que funcionalidades têm acesso?**  
**R:** O informático dá permissões aos utilizadores (roles) mas é necessário a equipa de desenvolvimento descobrir em que consiste cada role.

**Compatibilidade com equipamentos:** sim, mas como?  
**Acesso ao Excel:** vai enviar o template com o registo das análises por email.  
**Preferência linguagem:** escolha por parte da equipa de desenvolvimento.  
**Tem acesso à pasta dos Excel:** É o gestor da rede mas não consulta os dados (são confidenciais).  
**Responsável:** Engenheiro responsável

## Médico:

#### Muitas expectativas para o sistema. Faz o registo inicial do recetor (nome, data, nível de urgência). Só pessoas autorizadas têm acesso (médico e enfermeiro). O médico é que quis este sistema, não foi o diretor. O médico disse que "O diretor não percebe nada disto" (Conflito interno). Também faz a primeira consulta do recetor e o acompanhamento até ao transplante do orgão. Responsável por informação de dadores.

**Como é feito o registo de utentes? Que dados do utente são inseridos?**  
**R:** Registam data de entrada do utente (número sequencial), quem registou no Excel, foto, que orgãos necessita, dados pessoais (nome, data de nascimento, documento de identificação nacional, IMC), dados médicos clínicos (quem é o médico assistente, qual o grau de urgência, qual o sangue, HLA (A,B,DR,DQ), transplantes anteriores (data, local) e as análises víricas.

**Como é definido o estado de saúde do recetor?**  
**R:** O médico irá enviar por email a especificação dos estados de saúde (SU, CT, CD).

**Pode explicar como funciona o processo de despejo de orgãos impróprios?**  
**R:** Os orgãos estão nos hospitais (CITO trabalha com amostras). Não existe registo de orgãos disponiveis. O médico não sabe como são destruidos os orgãos e o processo de despejo de orgãos não interessa para o sistema.

**Como é feito o registo de um transplante?**  
**R:** O hospital envia os dados ao CITO e este regista no sistema a data, local, recetor e que orgão foi transplantado. Existem três candidatos para um orgão e o hospital escolhe o candidato. Depois é registado se o transplante foi efetuado com sucesso ou não.

**Existe algum documento que nos possa fornecer para pesquisa do processo?**  
**R:** O médico irá enviar por email como é feita a prioritização na escolha do candidato para receber um orgão.

**Como é a interação entre o departamento médico e os restantes departamentos (partilha de informação)?**  
**R:** Só enfermeiro e médico podem ver os dados do utente. O informático não pode ter acesso a estes dados. Diretor não pode ver dados, não pode fazer nada.

## Laboratório:

### Pegamos em amostras, analisamos a amostra, e registamos os resultados dessa análise. Tubos são armazenados em arcas frigorificas.

**Quem insere os dados das análises (tanto do dador como do recetor)?**  
**R:** Insere os dados no excel (digitalizar).

**Como irá utilizar a solução (inserir, consultar dados)?**  
**R:** Ficar automático, registar dados nos sistemas, iam aos equipamentos buscar os dados (dados das análises), enviaram os dados para o equipamento (recolha de análises).

**Quem realiza as análises? Enfermeiros?**  
**R:** O equipamento realiza, de forma automática, a análise a uma amostra de um orgão.

**Como é a interação entre o laboratório e os restantes departamentos (partilha de informação)? De que forma são enviados os dados das análises?**  
**R:** Médicos, enfermeiro consultam os dados que lhe são enviados por email (cópias de ficheiros Excel)

**Que dados refletem as análises (parâmetros)?**  
**R:** O técnico de laboratório irá enviar por email. Parâmetros não variam de orgão para orgão.

### Perguntas não efetuadas:

- Como é feita a marcação das análises? (Laboratório)
- Visto que o registo dos utentes é feito através de um ficheiro excel, como garantir confidencialidade? (Informático)
- Qual o custo base e custo mensal de manutenção disponível para esta digitalização? (Informático/Diretor/Administrativo)
- Como é notificado o recetor no caso de existir um orgão disponível? (Informático/Médico/Enfermeiro)
- Como funciona o processo desde que existe um orgão até este ser transplantado para um recetor? (Médico/Enfermeiro)
- Como funciona o processo após a colheita dos orgãos (análises, características do recetor/dador)? (Médico/Enfermeiro/Laboratório)
- Pode descrever o processo de match entre o dador e o recetor? (Médico/Enfermeiro/Laboratório)
- Como irá utilizar a solução (inserir, consultar dados)? (Médico)
- Como é feito o acompanhamento do recetor após o transplante? (Médico/Enfermeiro)
- Que características definem um orgão como indisponível? (Médico/Enfermeiro/Laboratório)
- Como é feita a marcação das análises, tanto do recetor como de uma amostra de um orgão? (Médico/Enfermeiro/Laboratório)
- É possível o recetor receber mais que um orgão? (Médico/Enfermeiro)

### Notas:

- Os médicos/enfermeiro irão consultar os dados das análises através do sistema.
- Orgão ou é na hora ou não é utilizado.
- Pedir mais documentos aos stakeholders (Templates Excels, parametrizações, etc).
- Fazer a pergunta se existe algo interessante que pretende partilhar.
- Variar os métodos de recolha de requisitos (técnicas das aulas teóricas).
