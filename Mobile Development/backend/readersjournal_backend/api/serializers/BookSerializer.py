# serializers.py
from rest_framework import serializers

from api.models import Book


class BookSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model = Book
        fields = ('title', 'author', 'rating', 'short_review', 'user')
