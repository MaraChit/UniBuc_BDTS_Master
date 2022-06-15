from django.db import models


class Book(models.Model):
    title = models.CharField(max_length=100)
    author = models.CharField(max_length=100)
    rating = models.FloatField()
    short_review = models.TextField()
    user = models.ForeignKey('User', on_delete=models.DO_NOTHING, null=True, blank=True)

