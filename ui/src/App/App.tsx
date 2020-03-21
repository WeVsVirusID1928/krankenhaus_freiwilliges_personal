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
        {postings?.map((posting: any) => {
          return (
            <li>
              <ul>
                <li>Titel: {posting.title}</li>
                <li>Zeit: {posting.time}</li>
                <li>Kommentar: {posting.comment}</li>
                <li>Kontakt: {posting.contact}</li>
              </ul>
            </li>
          );
        })}
      </ul>
    </>
  );
}

export default App;
