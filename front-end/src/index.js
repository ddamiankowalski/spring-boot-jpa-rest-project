import React from 'react';
import ReactDOM from 'react-dom';
import { useEffect } from 'react';

const App = () => {
  return (
    <div>This is a simple app for a University Project purposes</div>
  )
}

ReactDOM.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>,
  document.getElementById('root')
);

