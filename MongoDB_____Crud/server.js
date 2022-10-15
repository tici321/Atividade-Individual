const express=require('express')
const app=express()
const bodyParser = require('body-parser')
app.set('view ingine', 'ejs')
app.use(bodyParser.urlencoded({extended:true}))


const MongoClient=require('mongodb').MongoClient
const ObjectId=require('mongodb').ObjectId

const caminho="mongodb://localhost/AlicesTravel"

MongoClient.connect(caminho,{useNewUrlParser: true, useUnifiedTopology:true},(err, client)=>
{db=client.db('AlicesTravel')})

app.get('/',(req,res)=>{
    res.render('index.ejs')
})



app.post('/show',(req,res)=>{
    db.collection('Clientes').insertOne(req.body, (err,result)=>{
        console.log('Dados salvo com sucesso!!!')
        res.redirect('/show')
        
    })
})
app.get('/show', (req, res)=>{
    db.collection('Clientes').find().toArray((err, results)=>
 {res.render('show.ejs', {data: results})
 
 })
})

//=================================ATUALIZA===========================================================

app.route('/edit/:id')
.get((req, res) => {
  var id = req.params.id

  db.collection('Clientes').find(ObjectId(id)).toArray((err, result) => {
    if (err) return res.send(err)
    res.render('edit.ejs', { data: result })
  })
})
.post((req, res) => {
  var id = req.params.id
  var Nome = req.body.Nome
  var Email = req.body.Email
  var Usuario = req.body.Usuario
  var Senha = req.body.Senha

  db.collection('Clientes').updateOne({_id: ObjectId(id)}, {
    $set: {
      Nome: Nome,
      Email: Email,
      Usuario: Usuario,
      Senha: Senha
    }
  }, (err, result) => {
    if (err) return res.send(err)
    res.redirect('/show')
    console.log('Atualizado no Banco de Dados')
  })
})


//====================================DELETE===============================================================

app.route('/delete/:id')
.get((req, res) => {
  var id = req.params.id

  db.collection('Clientes').deleteOne({_id: ObjectId(id)}, (err, result) => {
    // if (err) return res.send(500, err)
    console.log('Deletado do Banco de Dados!')
    res.redirect('/show')
  })
})

//=========================================================================================================

app.listen(3000, function() {
    console.log('server running on port 3000')
})