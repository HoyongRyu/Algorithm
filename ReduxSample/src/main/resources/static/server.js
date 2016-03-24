var webpack = require('webpack');
var webpackDevMiddleware = require('webpack-dev-middleware');
var webpackHotMiddleware = require('webpack-hot-middleware');
var config = require('./webpack.config');
var request = require('request');

var app = new (require('express'))();
var port = 3000;

var compiler = webpack(config);
app.use(webpackDevMiddleware(compiler, { noInfo: true, publicPath: config.output.publicPath }));
app.use(webpackHotMiddleware(compiler));

var htmlFilePath = __dirname + '/assets';

app.get("/", function(req, res) {
  console.log("index file : " + htmlFilePath + '/index.html');
  res.sendFile(htmlFilePath + '/index.html');
})

app.use('/api', (req, res) => {
  req.pipe(request('http://localhost:8080/api' + req.url)
    .on('error', (e) => { console.warn(e.message) }))
    .pipe(res);
});

app.use('*', (req, res) => {
  req.pipe(request('http://localhost:3000/index.html')).pipe(res);
});

app.listen(port, function(error) {
  if (error) {
    console.error(error);
  } else {
    console.info("==> 🌎  Listening on port %s. Open up http://localhost:%s/ in your browser.", port, port);
  }
})
