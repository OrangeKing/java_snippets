var colorize = function(text) 
{
    var pattern = /<html>/i;    
    var match = text.replace(/<html>/i, "$&<body style=\"color:red\">");
    return match;
};