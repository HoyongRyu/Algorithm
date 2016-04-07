var path = require('path');
var webpack = require('webpack');
var HtmlWebpackPlugin = require('html-webpack-plugin');
var jeet = require('jeet');
var nib = require('nib');

module.exports = {
  devtool: 'inline-source-map',
  entry: [
    'webpack-hot-middleware/client',
    './src/index'
  ],
  debug: true,
  output: {
    path: path.join(__dirname, 'dist'),
    filename: 'bundle.js',
    publicPath: 'http://localhost:3000/' //PRD => dist/
  },
  plugins: [
    new webpack.HotModuleReplacementPlugin(),
    new webpack.NoErrorsPlugin(),
    new webpack.DefinePlugin({
      "process.env": {
        NODE_ENV: JSON.stringify('development')
      }
    }),
    new HtmlWebpackPlugin({
      title: 'Boot React',
      template: path.join(__dirname, 'assets/index.html')
    })
  ],
  resolve: {
    extensions: ['', '.js'],
    root: [
      path.join(__dirname, 'src'),
      path.join(__dirname, 'assets')
    ]
  },
  module: {
    loaders: [{
      test: /\.js$/,
      loaders: ['babel'],
      include: path.join(__dirname, 'src')
    }, {
      test: /\.json/,
      loaders: ['json-loader']
    }, {
      test: /\.(png|jpg)$/,
      loader: 'url?limit=3000000'
    }, {
      test: /\.html/,
      loaders: ['html']
    }, {
      test: /\.(styl|css)$/,
      loaders: ['style-loader', 'css-loader', 'stylus-loader']
    }]
  },
  htmlLoader: {
    ignoreCustomFragments: [/\{\{.*?}}/]
  },
  stylus: {
    use: [jeet(), nib()]
  },
};
