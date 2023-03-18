<template>
  <div class="layout">
    <div>hello-vue [{{ profile }}]</div>
    <br />
    <button @click="callHelloApi">hello</button>
    <div>{{ result }}</div>
  </div>
</template>

<script>
const API_FAIL_MESSAGE = 'api call fail.';

export default {
  data() {
    return {
      profile: import.meta.env.VITE_PROFILE,
      result: '',
    };
  },
  methods: {
    async callHelloApi() {
      try {
        const response = await fetch(`${process.env.API_ORIGIN}/api/hello`);
        if (!response.ok) {
          this.result = API_FAIL_MESSAGE;
          return;
        }

        this.result = await response.text();
      } catch (e) {
        this.result = API_FAIL_MESSAGE;
      }
    },
  },
  watch: {
    result(result) {
      if (result !== '') {
        setTimeout(() => {
          this.result = '';
        }, 3000);
      }
    },
  },
};
</script>

<style scoped>
.layout {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
</style>
