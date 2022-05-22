const { defineConfig } = require("@vue/cli-service");
module.exports = defineConfig({
  transpileDependencies: true,
  devServer: {

    proxy: {
      // '/': {
      //   target: "http://localhost:9999/",
      //   // "pathRewrite": { '^/': '' },
      //   // "changeOrigin": true,
      //   "secure": false
      // },
      '^/websocket': {
        target: "http://localhost:9999/",
        ws: true,
        changeOrigin: true
      }
    },
  },
});
