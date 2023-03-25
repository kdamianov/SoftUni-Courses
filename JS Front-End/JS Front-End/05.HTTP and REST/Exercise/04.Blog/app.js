function attachEvents() {
    const BASE_URL = 'http://localhost:3030/jsonstore/blog';
    const loadPostsBtn = document.getElementById('btnLoadPosts'); //posts
    const viewPostBtn = document.getElementById('btnViewPost'); //comments
    const postsContainer = document.getElementById('posts');
    const posts = [];

    loadPostsBtn.addEventListener('click', loadPostsHandler)
    viewPostBtn.addEventListener('click', viewPostHandler)

    function loadPostsHandler() {
        fetch(`${BASE_URL}/posts`)
            .then(response => response.json())
            .then(data => {
                Object.entries(data).forEach(([key, value]) => {
                    const postOption = document.createElement('option');
                    postOption.setAttribute('value', key);
                    postOption.textContent = value.title;
                    postsContainer.appendChild(postOption);
                    posts.push({ title: value.title, body: value.body, id: value.id })

                })
            })
            .catch(error => console.error(error))

    }

    function viewPostHandler() {
        document.getElementById('post-comments').innerHTML = '';
        fetch(`${BASE_URL}/comments`)
            .then(response => response.json())
            .then(data => {
                console.log(data)
                let selectedOption = postsContainer.selectedOptions[0].textContent;
                document.getElementById('post-title').textContent = selectedOption;
                let currentPost = posts.filter(p => p.title === selectedOption);
                let currentPostContent = currentPost[0].body;
                document.getElementById('post-body').textContent = currentPostContent;
                let postId = currentPost[0].id;
                let commentsArr = Object.entries(data);
                document.getElementById('post-comments').innerHTML = '';
                commentsArr.forEach(commentObj => {
                    // debugger
                    if (commentObj[1].postId === postId) {
                        const comment = document.createElement('li');
                        comment.textContent = commentObj[1].text;
                        document.getElementById('post-comments').appendChild(comment);
                    }
                })
                    
        
                
            })
            .catch(error => console.log(error))
    }
}



attachEvents();