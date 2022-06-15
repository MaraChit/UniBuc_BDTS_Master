from rest_framework import viewsets, status
from rest_framework.decorators import action
from rest_framework.response import Response

from api.serializers import UserSerializer, BookSerializer
from api.models import User, Book


class BookViewSet(viewsets.ModelViewSet):
    queryset = Book.objects.all()
    serializer_class = BookSerializer

    @action(detail=False, methods=['POST'])
    def addbook(self, request):
        username = request.data["username"]
        title = request.data["title"]
        rating = int(request.data["rating"])
        short_review = request.data["shortReview"]
        author = request.data["author"]
        user = User.objects.filter(username__exact=username).first()
        Book.objects.create(user=user, title=title, rating=rating, short_review=short_review, author=author)
        return Response(status=status.HTTP_202_ACCEPTED)

    @action(detail=False, methods=['POST'])
    def getbook(self, request):
        username = request.data["username"]
        user = User.objects.filter(username__exact=username).first()
        books = []
        for book in list(Book.objects.filter(user=user)):
            books.append(dict(title=book.title, rating=book.rating, short_review=book.short_review, author=book.author))
        return Response(status=status.HTTP_202_ACCEPTED, data=list(books))

