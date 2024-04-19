/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./templates/*.html"],
  theme: {
    extend: {
      spacing: {
        '112': '28rem',
        '128': '32rem',
      }
    },
  },
  plugins: [],
}

