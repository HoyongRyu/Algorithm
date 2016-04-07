const logger = process.env.NODE_ENV === 'development' ? console.log.bind(console) : function () {};

export default logger;