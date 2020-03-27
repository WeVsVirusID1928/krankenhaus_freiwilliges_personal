module.exports = {
  devServer: {
    proxy: {
      "/api": {
        target: "http://localhost:8443",   //TODO: put url somewhere else
        pathRewrite: { "^/api": "" },
        changeOrigin: true
      }
    }
  }
};
