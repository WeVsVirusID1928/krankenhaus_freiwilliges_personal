module.exports = {
  devServer: {
    proxy: {
      "/api": {
        target: "http://backend:8443", //TODO: put url somewhere else
        pathRewrite: { "^/api": "" },
        changeOrigin: true
      }
    }
  }
};
