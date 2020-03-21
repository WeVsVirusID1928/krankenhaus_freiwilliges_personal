import React from 'react';
import { usePostings } from './usePostings';

function App() {
  const [postings, loading, error] = usePostings();

  console.log(postings);

  if (loading) {
    return <p>loading...</p>;
  } else if (error) {
    return <p>❌ Failed to talk to backend</p>;
  }

  return (
    <>
      <h3>This is what the server said:</h3>
      <ul>
        {(postings as any).zeug.postings.map((posting: any) => {
          return <li>{JSON.stringify(posting)}</li>;
        })}
      </ul>
    </>
  );
}

export default App;
