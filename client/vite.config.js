import {fileURLToPath, URL} from 'node:url';

import {defineConfig} from 'vite';
import vue from '@vitejs/plugin-vue';

export default defineConfig(() => {
  return {
    define: {
      process: {
        env: {
          ...process.env,
          API_ORIGIN: `${process.env.PROTOCOL}${process.env.DOMAIN}:${process.env.NGINX_PORT}`,
        },
      },
    },
    server: {
      host: true,
      port: process.env.PORT,
    },
    plugins: [vue()],
    resolve: {
      alias: {
        '@': fileURLToPath(new URL('./src', import.meta.url)),
      },
    },
  };
});
