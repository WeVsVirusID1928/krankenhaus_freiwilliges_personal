import React from 'react';
import { usePingStatus } from './usePingStatus';

function App() {
  const [data, loading, error] = usePingStatus();

  if (loading) {
    return <p>loading...</p>;
  } else if (error) {
    return <p>❌ Failed to talk to backend</p>;
  }

  return (
    <>
      <h3>This is what the server said:</h3>
      <pre>{JSON.stringify(data)}</pre>
    </>
  );
}

export default App;
