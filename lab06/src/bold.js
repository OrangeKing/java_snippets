var bold = function(text) 
{
    var pattern = /<html>/i;    
    var match = text.replace(/<html>(<body[^>]*>)?(?!<h1>)/i, "$&<h1>");
    return match;
};
